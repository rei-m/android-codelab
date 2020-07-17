package com.example.android.hilt.feature.savedstate.ui

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.android.hilt.feature.savedstate.R
import com.example.android.hilt.feature.savedstate.databinding.SavedStateFirstFragmentBinding
import com.example.android.hilt.feature.savedstate.ui.widget.DropdownSelectAdapter

class SavedStateFirstFragment : Fragment() {

    private var _binding: SavedStateFirstFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<TrainingMenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SavedStateFirstFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dropdown.setUpDropDown(listOf("いち", "に", "さん"))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.dropdown.setUp(viewModel.rangeFrom.label(resources)) {
            viewModel.rangeFrom = RangeFromCondition.values()[it]
        }
    }
}

fun AutoCompleteTextView.setUpDropDown(itemList: List<String>) {
    inputType = InputType.TYPE_NULL
    keyListener = null

    val adapter = DropdownSelectAdapter(
        context,
        R.layout.dropdown_menu_popup_item,
        itemList
    )
    setAdapter(adapter)
}

fun AutoCompleteTextView.setUp(
    initialValue: String,
    onSelected: (position: Int) -> Unit
) {
    setText(initialValue, false)

    setOnItemClickListener { _, _, position, _ ->
        onSelected(position)
    }
}