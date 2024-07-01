package ru.itis.summer24.ex2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summer24.ex2.databinding.FragmentPromocodeBinding

class PromocodeFragment : Fragment(R.layout.fragment_promocode) {

    private var binding: FragmentPromocodeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPromocodeBinding.bind(view)

        val promo = arguments?.getString(PROMO) ?: "ERROR"

        binding?.run {
            promoscreen.text = "${promoscreen.text} : \n $promo"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val PROMO = "PROMO"

        fun bundle(promo: String): Bundle = Bundle().apply {
            putString(PROMO, promo)
        }
    }

}