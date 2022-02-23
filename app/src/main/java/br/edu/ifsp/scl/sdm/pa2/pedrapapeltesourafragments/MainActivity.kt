package br.edu.ifsp.scl.sdm.pa2.pedrapapeltesourafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import br.edu.ifsp.scl.sdm.pa2.pedrapapeltesourafragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        with(supportFragmentManager.beginTransaction()) {
            setReorderingAllowed(true)
            addToBackStack("principal")
            add(R.id.principalFcv, MainFragment(), "MainFragment")
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.editarMi -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack("opcoes")
                    replace(R.id.principalFcv, EditarOpcoesFragment(), "OpcoesFragment")
                }
                true
            }else -> {
                false
            }

        }
    }
}