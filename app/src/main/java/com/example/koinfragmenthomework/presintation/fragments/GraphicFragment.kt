package com.example.koinfragmenthomework.presintation.fragments


import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.domain.models.forView.GraphicCardForView
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.recycler.edit.AdapterRecyclerEdit
import com.example.koinfragmenthomework.presintation.viewModel.GraphicViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_graphic.*
import kotlinx.android.synthetic.main.recycler_patern_edit.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GraphicFragment : Fragment(R.layout.fragment_graphic) {
    companion object {
        const val TAG = "GRAPHIC"
        fun newInstance() = GraphicFragment()
    }

    private val viewModel: GraphicViewModel by viewModel()

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    private val adapter by lazy { AdapterRecyclerEdit(this, viewModel, sharedViewModel) }

    override fun onStart() {
        super.onStart()
        openRecycler()
        openFragmentGraphicCard()

    }

    private fun openRecycler() {
        sharedViewModel.count.observe(viewLifecycleOwner) { count ->
            adapter.submit("Видеокарта", count)
        }
        recyclerEditCard.adapter = adapter
    }

    private fun openFragmentGraphicCard() {
        btnGraphic.setOnClickListener {
            if (editRecycler.text.isEmpty()) {
                showToast("Выберите Видеокарту")
            } else {
                sharedViewModel.info.observe(viewLifecycleOwner) { string ->
                    sharedViewModel.putGraphic(GraphicCardForView(string))

                }

                requireActivity().openFragment(
                    CountMonitorFragment.TAG,
                    R.id.container,
                    CountMonitorFragment.newInstance()
                )
            }
        }
    }
}