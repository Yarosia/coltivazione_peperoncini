package yarosia.coltivazionepeperoncini.content;

import android.provider.BaseColumns;

/**
 * Created by valen on 29/01/2016.
 */
public interface ProvenienzaTable extends BaseColumns {
    String TABLE_NAME = "PROVENIENZA_TABLE";

    String NOME = "nome";

    String NOTE = "note";

    String[] COLUMNS = new String[]{_ID, NOME, NOTE};
}
