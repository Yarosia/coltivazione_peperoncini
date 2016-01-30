package yarosia.coltivazionepeperoncini.content;

import android.provider.BaseColumns;

/**
 * Created by valen on 29/01/2016.
 */
public interface CultivarTable extends BaseColumns{
    String TABLE_NAME = "CULTIVAR_TABLE";

    String NOME = "nome";

    String SPECIE = "specie_id";



    String NOTE = "note";

    String[] COLUMNS = new String[] { _ID, NOME, SPECIE, NOTE };
}
