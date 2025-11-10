package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Gakusei;
import com.example.demo.mapper.GakuseiMapper;

@Service
public class GakuseiService {
	@Autowired
	private GakuseiMapper gakuseiMapper;

	// 调用 Mapper 的学生一览表画面内容的方法
	public List<Gakusei> getGakuseiKurasuTensuList(Gakusei gakusei) {
		return gakuseiMapper.getGakuseiKurasuTensuList(gakusei);
	}

	// 调用 Mapper 的学生详细画面内容的方法
	public Gakusei getGakuseiDetail(Gakusei gakusei) {
		return gakuseiMapper.getGakuseiDetail(gakusei);
	}

	// 调用 Mapper 的学生更新画面内容的方法
	public void updateGakuseiInfo(Gakusei gakusei) {
		gakuseiMapper.updateGakuseiInfo(gakusei);
	}

	// 更新画面的查询方法(getGakuseiById)
	public Gakusei getGakuseiById(Gakusei gakusei) {
		return gakuseiMapper.getGakuseiById(gakusei);
	}

	// 调用 Mapper 的学生新规画面-放大镜功能(班级名模糊検索)的方法
	public List<Gakusei> searchByKurasuNamae(String kurasuNamae) {
		return gakuseiMapper.searchByKurasuNamae(kurasuNamae);
	}

	/* 将填写好的字段存入数据库中 */
	public void insertGakusei(Gakusei gakusei) {
		if (gakusei.getTensu() == null) {
			gakusei.setTensu(20);
		}
		gakusei.setDeleteFlag(0); // 防止 DELETE_FLAG 为空，查询时被过滤掉
		gakuseiMapper.insert(gakusei);
	}

	/* 删除学生数据（论理删除）*/
	public void deleteGakuseiInfo(int gakuseiId) {
		gakuseiMapper.deleteGakuseiInfo(gakuseiId);
	}

}
