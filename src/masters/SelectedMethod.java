package masters;

import java.util.List;
import competitor.Competitor;

public interface SelectedMethod{
  List<Competitor> playPool(List<Competitor> c);
  List<Competitor> addWinnersPool();
}
