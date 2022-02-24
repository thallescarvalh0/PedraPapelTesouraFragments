package br.edu.ifsp.scl.sdm.pa2.pedrapapeltesourafragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import br.edu.ifsp.scl.sdm.pa2.pedrapapeltesourafragments.databinding.ActivityMainBinding
import br.edu.ifsp.scl.sdm.pa2.pedrapapeltesourafragments.databinding.FragmentEditarOpcoesBinding

class EditarOpcoesFragment : Fragment() {

    private lateinit var editarOpcoesBinding: FragmentEditarOpcoesBinding
    private var jogadores = 0
    private var rodadas = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editarOpcoesBinding = FragmentEditarOpcoesBinding.inflate( inflater, container, false)

        editarOpcoesBinding.rbDoisJogadores.setOnClickListener {
            jogadores = 0
        }
        editarOpcoesBinding.rbTresJogadores.setOnClickListener {
            jogadores = 1
        }

        editarOpcoesBinding.rbUmaRodada.setOnClickListener {
            rodadas = 1
        }
        editarOpcoesBinding.rbTresRodadas.setOnClickListener {
            rodadas = 3
        }
        editarOpcoesBinding.rbCincoRodadas.setOnClickListener {
            rodadas = 5
        }

        editarOpcoesBinding.btnSalvar.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("RODADA" to rodadas,"JOGADORES" to jogadores))
            activity?.supportFragmentManager?.popBackStack()
        }

        return editarOpcoesBinding.root
    }


}