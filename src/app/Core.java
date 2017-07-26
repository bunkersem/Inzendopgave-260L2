package app;

import java.util.List;

/**
 * Created by Sem on 25-Jul-17.
 */
public class Core {
    public static <T> T last (List<T> list) {
        if (list.size() > 0)
            return list.get(list.size() - 1);
        else return null;
    }
    public static boolean isRound(float val) {
        return val == Math.round(val);
    }
}
