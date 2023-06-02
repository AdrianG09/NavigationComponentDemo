package com.example.navigationcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.navigationcomponentdemo.databinding.FragmentReplyBinding
import com.example.navigationcomponentdemo.databinding.FragmentSendMessageBinding

class SendMessageFragment : Fragment() {

    private var _binding: FragmentSendMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSendMessageBinding.inflate(inflater, container, false)
        val rootView = binding.root

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getString("bundleKey")

            binding.replyHeader.visibility = View.VISIBLE
            binding.replyTextview.visibility = View.VISIBLE
            binding.replyTextview.text = result
        }

        binding.sendButton.setOnClickListener {
            val message = binding.messageEdittext.text.toString()

            val action = SendMessageFragmentDirections.actionSendMessageFragmentToReplyFragment(message)
            rootView.findNavController().navigate(action)
        }

        return rootView
    }

}