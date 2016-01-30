package yarosia.coltivazionepeperoncini.content;

import android.provider.BaseColumns;

/**
 * Created by valen on 29/01/2016.
 */
public interface SemiTable extends BaseColumns{
    String TABLE_NAME = "SEMI_TABLE";
    /**
     * nome cultivar anno provenienza datasemina datagerminazione datacotiledoni datafoglie datatrapianto isolato note
     */

    String CULTIVAR = "cultivar_id";

    String NOME = "nome";

    String ANNO = "anno_id";

    String PROVENIENZA = "provenienza_id";

    String DATA_SEMINA ="data_semina";

    String DATA_GERMINAZIONE ="data_germinazione";

    String DATA_COTILEDONI = "data_cotiledoni";

    String DATA_FOGLIE = "data_foglie";

    String DATA_TRAPIANTO = "data_trapianto";

    String ISOLATO = "isolato";

    String NOTE = "notes";

    String[] COLUMNS = new String[] { _ID, NOME, CULTIVAR, ANNO, PROVENIENZA,DATA_SEMINA,DATA_GERMINAZIONE,DATA_COTILEDONI,DATA_FOGLIE,DATA_TRAPIANTO,ISOLATO,NOTE};
}
