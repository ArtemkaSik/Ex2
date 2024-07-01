package ru.itis.summer24.ex2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summer24.ex2.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.apply {
            sendTextBtn.setOnClickListener {
                val inputText = promo.text.toString().trim()
                if (inputText.isEmpty()) {
                    Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
                } else {
                    findNavController().navigate(
                        resId = R.id.action_mainFragment_to_promocodeFragment,
                        args = PromocodeFragment.bundle(
                            promo = inputText
                        )
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}