package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * 
 * @author ManiKandan V
 *
 */
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			try {
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(000001, "sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
						"Main Course", true));
				menuItemList.add(new MenuItem(000002, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
						"Main Course", false));
				menuItemList.add(new MenuItem(000003, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
						"Main Course", false));
				menuItemList.add(new MenuItem(000004, "French Fries", 57.00f, false,
						DateUtil.convertToDate("02/07/2017"), "Starters", true));
				menuItemList.add(new MenuItem(000005, "Chocolate Brownie", 32.00f, true,
						DateUtil.convertToDate("02/11/2022"), "Dessert", true));

			} catch (ParseException pe) {
				System.out.println("Parse Exception " + pe.getMessage());
			}
		}

	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<MenuItem> mpl = new ArrayList<MenuItem>();
		Date today = new Date();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().getTime() <= today.getTime() && menuItem.isActive()) {
				mpl.add(menuItem);
			}
		}
		return mpl;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for (MenuItem menu_item_modify : menuItemList) {
			if (menuItem.getId() == menu_item_modify.getId()) {
				menu_item_modify.setName(menuItem.getName());
				menu_item_modify.setCategory(menuItem.getCategory());
				menu_item_modify.setDateOfLaunch(menuItem.getDateOfLaunch());
				menu_item_modify.setPrice(menuItem.getPrice());
				menu_item_modify.setActive(menuItem.isActive());
				menu_item_modify.setFreeDelivery(menuItem.isFreeDelivery());
			}
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem menu_item : menuItemList) {
			if (menuItemId == menu_item.getId()) {
				return menu_item;
			}
		}

		return null;
	}

}
