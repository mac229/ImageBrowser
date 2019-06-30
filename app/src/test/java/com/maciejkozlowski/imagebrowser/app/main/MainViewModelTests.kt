package com.maciejkozlowski.imagebrowser.app.main

import com.maciejkozlowski.imagebrowser.api.ApiService
import com.maciejkozlowski.imagebrowser.api.errors.ApiErrorMapper
import com.maciejkozlowski.imagebrowser.base.TestSchedulersProvider
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainViewModelTests {

    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var apiErrorMapper: ApiErrorMapper

    @Mock
    private lateinit var imageUrlConverter: ImageUrlConverter

    private val testSchedulersProvider = TestSchedulersProvider()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUpMockito() {
        MockitoAnnotations.initMocks(this)
    }

    @Before
    fun initViewModel() {
        val repository = MainRepository(apiService, apiErrorMapper, imageUrlConverter, testSchedulersProvider)
        viewModel = MainViewModel(repository)
    }

    @Test
    fun fetchData_success() {

    }

    @Test
    fun fetchData_noInternet() {

    }

    @Test
    fun fetchData_unknownError() {

    }
}
