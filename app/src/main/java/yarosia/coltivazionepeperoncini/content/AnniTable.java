package yarosia.coltivazionepeperoncini.content;

import android.provider.BaseColumns;

/**
 * Created by valen on 29/01/2016.
 */
public interface AnniTable extends BaseColumns{
    String TABLE_NAME = "ANNI_TABLE";

    String ANNO = "anno"; //testo

    String NOTE = "note"; //testo



    String[] COLUMNS = new String[] { _ID, ANNO, NOTE };
}
