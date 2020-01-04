package nl.mohinder.bottomnavigationviewkotlin.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_rate.*

import nl.mohinder.bottomnavigationviewkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class RateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRate.setOnClickListener {
            val action = RateFragmentDirections.actionRateFragmentToRatedFragment(rbRate.rating)
            findNavController().navigate(action)
        }
    }


}
