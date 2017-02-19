package com.example.marquesdesouza.appgps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import com.example.marquesdesouza.appgps.MODEL.Aluno;
/**
 * Created by Marques de Souza on 17/02/2017.
 */

public class FormularioHelper {
        private final EditText campoNome;
        private final EditText campoEndereco;
        private final EditText campoTelefone;
        private final EditText campoSite;
        private final RatingBar campoNota;
        private final ImageView campoFoto;

        private Aluno aluno;

        public FormularioHelper(FormularioActivity activity) {
            campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
            campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
            campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
            campoSite = (EditText) activity.findViewById(R.id.formulario_site);
            campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
            campoFoto = (ImageView) activity.findViewById(R.id.formulario_foto);
            aluno = new Aluno();
        }

        public Aluno pegaAluno() {
            aluno.setNome(campoNome.getText().toString());
            aluno.setEndereco(campoEndereco.getText().toString());
            aluno.setTelefone(campoTelefone.getText().toString());
            aluno.setSite(campoSite.getText().toString());
            aluno.setNota(Double.valueOf(campoNota.getProgress()));
            if(campoFoto.getTag()==null){
                aluno.setCaminhoFoto("vazio");
            }else {
                aluno.setCaminhoFoto((String) campoFoto.getTag());
            }
            return aluno;
        }

        public void preencheFormulario(Aluno aluno) {
            campoNome.setText(aluno.getNome());
            campoEndereco.setText(aluno.getEndereco());
            campoTelefone.setText(aluno.getTelefone());
            campoSite.setText(aluno.getSite());
            campoNota.setProgress(aluno.getNota().intValue());
            if(aluno.getCaminhoFoto().equals("vazio")){}else{
            carregaImagem(aluno.getCaminhoFoto());}
            this.aluno = aluno;
        }

        public void carregaImagem(String caminhoFoto) {
            if (caminhoFoto!="vazio") {
                Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
                Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
                campoFoto.setImageBitmap(bitmapReduzido);
                campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
                campoFoto.setTag(caminhoFoto);
            }
        }
}
