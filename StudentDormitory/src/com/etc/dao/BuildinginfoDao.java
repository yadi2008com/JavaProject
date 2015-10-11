package com.etc.dao;

import java.util.List;

import com.etc.bean.BuildinginfoBean;
import com.etc.bean.TeacherInfoBean;

public interface BuildinginfoDao {
	/**
	 * @功能：查找所有的楼宇信息
	 * @参数：无
	 * @返回值：List<BuildinginfoBean>--楼宇信息列表
	 */
	List<BuildinginfoBean> fetchAllBuildinfo();
	/**
	 * @功能：通过楼宇id删除楼宇
	 * @参数：id --楼宇id
	 * @返回值：int 返回修改的行数
	 */
	int deleteBuildingById(int id);
	/**
	 * @功能：通过楼宇名，判断楼宇名是否被占用
	 * @参数：name --楼宇名
	 * @返回值：boolean  true--名字被占用   false--名字没有被占用
	 */
	boolean isBuildingExits(String name);
	/**
	 * @功能：添加楼宇
	 * @参数：buildinginfoBean 楼宇信息实例
	 * @返回值：int=0 没有添加成功 int=1 添加成功
	 */
	int addBuilding(BuildinginfoBean buildinginfoBean);
	/**
	 * @功能：通过楼宇id得到楼宇信息
	 * @参数：id --楼宇id
	 * @返回值：BuildinginfoBean 楼宇信息
	 */
	BuildinginfoBean fetchBuildinginfoById(int id);
	/**
	 * @功能：更新楼宇信息
	 * @参数：buildinginfoBean 新的楼宇信息
	 * @返回值：int=0 表示更新失败   int=1 表示更新成功
	 */
	int updateBuilding(BuildinginfoBean buildinginfoBean);
	/**
	 * @功能：通过楼宇名得到楼宇信息
	 * @参数：searchKey --楼宇名
	 * @返回值：BuildinginfoBean 楼宇信息
	 */
	BuildinginfoBean fetchBuildinginfoByName(String searchKey);
	/**
	 * @功能：通过楼宇id查找改楼的楼宇管理员
	 * @参数：id 楼宇id
	 * @返回值：List<TeacherInfoBean>--楼宇管理员信息列表
	 */
	List<TeacherInfoBean> fetchTeacherinfoByBuildingId(int id);
	/**
	 * @功能：删除楼宇管理员，通过楼宇id
	 * @参数：id 楼宇id
	 * @返回值：int=0 表示删除失败   int=1 表示删除成功
	 */
	int deleteBuildingTeacherById(int id);
	/**
	 * @功能：查找没有分配出去的楼宇管理员
	 * @参数：无
	 * @返回值：List<TeacherInfoBean>--没有分配出去的楼宇管理员信息列表
	 */
	List<TeacherInfoBean> fetchNotAssignTeachers();
	/**
	 * @功能：为楼宇添加管理员
	 * @参数：buildingId 楼宇id   teacherId 管理员id
	 * @返回值：int=0 表示添加失败   int=1 表示添加成功
	 */
	int addBuildingTeacher(int buildingId, int teacherId);
	/**
	 * @功能：得到楼宇信息的行数
	 * @参数：无
	 * @返回值：int 返回楼宇信息的行数
	 */
	int getBuildinginfoRows();
	/**
	 * @功能：通过页号得到楼宇信息
	 * @参数：pageno --页号
	 * @返回值：BuildinginfoBean 楼宇信息
	 */
	List<BuildinginfoBean> fetchBuildinfoByPageno(int pageno);
	/**
	 * @功能：通过楼宇id和页号查找改楼的楼宇管理员
	 * @参数：id 楼宇id   pageno 页号
	 * @返回值：List<TeacherInfoBean>--楼宇管理员信息列表
	 */
	List<TeacherInfoBean> fetchTeacherinfoByBuildingIdPageno(int id, int pageno);
	/**
	 * @功能：得到楼宇管理员信息的行数
	 * @参数：id  楼宇id
	 * @返回值：int 返回楼宇管理员信息的行数
	 */
	int getBuildingTeacherinfoRowsByBuildingId(int id);

}
