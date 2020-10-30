package com.example.aura.adapterItems

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.models.ChildComment
import com.aura.auracustomer.models.Comment
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.comment_row.view.*
import kotlinx.android.synthetic.main.sub_comment.view.*

class ChildCommentItem (private val comment: ChildComment): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.sub_comment_user_title.text = comment.name
        viewHolder.itemView.sub_comment_text.text = comment.text
        viewHolder.itemView.sub_comment_date.text = comment.date

        Picasso.get()
            .load(comment.image)
            .into(viewHolder.itemView.sub_comment_user_image)
    }

    override fun getLayout(): Int {
        return R.layout.sub_comment
    }

}

class CommentItem (private val comment: Comment, private val context: Context): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val childCommentsAdapter = GroupAdapter<GroupieViewHolder>()
        val comment_reply = viewHolder.itemView.comment_reply
        val send_btn = viewHolder.itemView.comment_btn_send

        for (item in comment.comments) {
            childCommentsAdapter.add(ChildCommentItem(item))
        }

        viewHolder.itemView.comment_user_title.text = comment.name
        viewHolder.itemView.comment_text.text = comment.text
        viewHolder.itemView.comment_date.text = comment.date

        viewHolder.itemView.child_comments_recycler_view.layoutManager = LinearLayoutManager(context)
        viewHolder.itemView.child_comments_recycler_view.adapter = childCommentsAdapter

        comment_reply.setOnClickListener {
            if (send_btn.visibility == View.VISIBLE) {
                send_btn.visibility = View.INVISIBLE
                viewHolder.itemView.comment_text_field.visibility = View.INVISIBLE
                for (item in comment.comments) {
                    childCommentsAdapter.add(ChildCommentItem(item))
                }
            } else {
                send_btn.visibility = View.VISIBLE
                viewHolder.itemView.comment_text_field.visibility = View.VISIBLE
                childCommentsAdapter.clear()
            }
        }

        Picasso.get()
            .load(comment.image)
            .into(viewHolder.itemView.comment_user_image)
    }

    override fun getLayout(): Int {
        return R.layout.comment_row
    }

}