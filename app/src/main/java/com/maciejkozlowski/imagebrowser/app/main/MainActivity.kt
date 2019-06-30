package com.maciejkozlowski.imagebrowser.app.main

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.recyclerview.widget.GridLayoutManager
import com.maciejkozlowski.imagebrowser.R
import com.maciejkozlowski.imagebrowser.api.model.Image
import com.maciejkozlowski.imagebrowser.app.details.startImageDetailsActivity
import com.maciejkozlowski.imagebrowser.app.main.adapter.ImageClickListener
import com.maciejkozlowski.imagebrowser.app.main.adapter.ImageListAdapter
import com.maciejkozlowski.imagebrowser.base.base.BaseActivity
import com.maciejkozlowski.imagebrowser.base.di.ViewModelFactory
import com.maciejkozlowski.imagebrowser.base.utils.getScreenWidth
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    internal lateinit var factory: ViewModelFactory<MainViewModel>
    private val viewModel by lazy { getViewModel(factory) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        viewModel.viewStateLiveData.observe(this::onViewStateChanged)
        viewModel.fetchList(getTargetImageViewWidth())
    }

    private fun getTargetImageViewWidth() = windowManager.getScreenWidth() / SPAN_COUNT

    private fun onViewStateChanged(viewState: MainViewState) {
        when (viewState) {
            is MainViewState.Content   -> onDataFetched(viewState.list)
            MainViewState.Loading      -> return
            MainViewState.NoInternet   -> showToast(R.string.no_internet)
            MainViewState.UnknownError -> showToast(R.string.something_went_wrong)
        }
    }

    private fun showToast(@StringRes text: Int) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun onDataFetched(list: List<Image>) {
        recyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        recyclerView.adapter = ImageListAdapter(list, AdapterListener())
    }

    inner class AdapterListener : ImageClickListener {

        override fun onImageClicked(id: String) {
            startImageDetailsActivity()
        }
    }

    companion object {
        private const val SPAN_COUNT = 2
    }
}
