/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface LineItemsRepository {

	public void persistLineItems(LineItems li);

	public void persistLineItemss(List<LineItems> li);

	public LineItems findByID(long id);

	public ArrayList<LineItems> getLineItemss();

	public void updateLineItems(LineItems li);
}
