package jp.numero.motion_example.container

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import jp.numero.motion_example.R
import jp.numero.motion_example.databinding.FragmentContainerTransitionBinding

class ContainerTransitionFragment : Fragment() {

    private var _binding: FragmentContainerTransitionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContainerTransitionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.card.setOnClickListener { card ->
            val extras = FragmentNavigatorExtras(card to card.transitionName)
            findNavController().navigate(R.id.action_List_to_Detail, null, null, extras)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}