package com.example.giveback.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.giveback.GetBoard.GetBoardWriteActivity
import com.example.giveback.LostBoard.LostBoardWriteActivity
import com.example.giveback.R
import com.example.giveback.databinding.FragmentReportBinding

// 분실신고 페이지
class ReportFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_report, container, false)

        // 분실신고 화면의 GetWriteBtn을 클릭하면 GetBoardWriteActivity로 이동하도록 화면 이동 기능 구현
        binding.GetWriteBtn.setOnClickListener{
            val intent = Intent(context, GetBoardWriteActivity::class.java)
            startActivity(intent)
        }

        // 분실신고 화면의 LostWriteBtn을 클릭하면 LostBoardWriteActivity로 이동하도록 화면 이동 기능 구현
        binding.LostWriteBtn.setOnClickListener{
            val intent = Intent(context, LostBoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }

        return binding.root
    }

}