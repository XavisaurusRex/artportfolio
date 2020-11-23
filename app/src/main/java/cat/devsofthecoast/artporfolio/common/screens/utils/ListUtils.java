package cat.devsofthecoast.artporfolio.common.screens.utils;
import java.util.List;

public class ListUtils {
    public static <L> boolean isEmpty(List<L> list) {
        return list == null || list.isEmpty();
    }
}
