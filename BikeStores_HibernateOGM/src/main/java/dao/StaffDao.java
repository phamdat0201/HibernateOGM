package dao;

import model.Staff;

public interface StaffDao {
	public boolean addStaff(Staff sff);
	public boolean updateStaff(Staff sff);
	public boolean deleteStaff(long id);
	public Staff getStaff(long id);
}
