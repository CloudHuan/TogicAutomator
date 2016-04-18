package launcherClick;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Utils.IOUtils;
import Utils.Println;
import launcherClick.model.CellInfo;

public class AMetroParse {

	public static List<CellInfo> startParse(String url) {
		String str = IOUtils.readFromNet(url);
		if(str==null){
			return null;
		}
		JSONObject jsonObject = new JSONObject(str);
		List<CellInfo> list = new ArrayList<CellInfo>();
		JSONArray _tabs = jsonObject.getJSONArray("tabs");
		for(int i = 0;i<_tabs.length();i++){
			String tab = _tabs.getJSONObject(i).getString("label");
			JSONArray _cells = _tabs.getJSONObject(i).getJSONArray("cells");
			for(int j=0;j<_cells.length();j++){
				CellInfo cellInfo = new CellInfo();
				cellInfo.setX(_cells.getJSONObject(j).getJSONObject("location").getInt("x"));
				cellInfo.setY(_cells.getJSONObject(j).getJSONObject("location").getInt("y"));
				cellInfo.setLabel(_cells.getJSONObject(j).getJSONObject("content").getString("label"));
				cellInfo.setTab(tab);
				list.add(cellInfo);
			}
		}
		return list;
	}
}
