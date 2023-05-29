package brandao.android.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import brandao.android.fragments.R;
import brandao.android.fragments.fragments.ContatosFragment;
import brandao.android.fragments.fragments.ConversasFragmenta;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversas,buttonContatatos;
    private ConversasFragmenta conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonContatatos = findViewById(R.id.buttonContatos);
        buttonConversas = findViewById(R.id.buttonConversas);

        getSupportActionBar().setElevation(0);


        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                conversasFragment = new ConversasFragmenta();

                //Configurar objeto para fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                //finalizando a transação
                transaction.commit();
            }
        });


        buttonContatatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.frameConteudo, contatosFragment);
                transaction2.commit();
            }
        });

    }
}