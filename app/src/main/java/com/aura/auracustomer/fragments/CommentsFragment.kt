package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.example.aura.adapterItems.CommentItem
import com.aura.auracustomer.models.ChildComment
import com.aura.auracustomer.models.Comment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_comments.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommentsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val childComments1 = arrayListOf(
        ChildComment(3452,"https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg", "awd",
            "fregre","2020-11-08"),
        ChildComment(3452,"https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg", "kiului",
            "gthytj","2020-11-08")
    )
    private val childComments2 = arrayListOf(
        ChildComment(3402,"https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg", "awd",
            "fregre","2020-11-08"),
        ChildComment(3402,"https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg", "kiului",
            "gthytj","2020-11-08")
    )

    private val commentsAdapter = GroupAdapter<GroupieViewHolder>()
        .apply {
            add(
                CommentItem(
                    Comment(3452, "https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg",
                        "awda", "awdeww", "2020-04-06",
                        childComments1
                    ),
                    MainActivity()
                )
            )
            add(
                CommentItem(
                    Comment(3402, "https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg",
                        "kiului", "awdeww", "2020-04-06",
                        childComments2
                    ),
                    MainActivity()
                )
            )
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Отзывы"


        comments_recyclerView.layoutManager = LinearLayoutManager(this.context)
        comments_recyclerView.adapter = commentsAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommentsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommentsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}