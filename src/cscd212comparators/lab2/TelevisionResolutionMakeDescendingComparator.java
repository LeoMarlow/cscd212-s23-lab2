package cscd212comparators.lab2;
import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator extends Object implements Comparator<Television> {
    public int compare(Television t1, Television t2){

            if(t1 == null || t2 == null)
                throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");

        if(t1.getResolution() == t2.getResolution())
            return t2.getMake().compareTo(t1.getMake());
        return t2.getResolution() - t1.getResolution();
    }

}