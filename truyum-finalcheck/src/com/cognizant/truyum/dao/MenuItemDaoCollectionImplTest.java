package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * 
 * @author ManiKandan V
 *
 */
public class MenuItemDaoCollectionImplTest {
	public static void main(String args[]) {
		testGetMenuItemlistAdmin();
		testGetMenuItemListCustomer();

	}

	public static void testGetMenuItemlistAdmin() {
		MenuItemDaoCollectionImpl MenuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems = MenuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDaoCollectionImpl MenuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems = MenuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.toString());
		}

	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItemDaoCollectionImpl menuitemcollectionimpl = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = new MenuItem(000002, "Cake", 180.00f, true, DateUtil.convertToDate("20/11/2012"),
				"Main Course", false);
		MenuItemDao menuitemdao = menuitemcollectionimpl;
		menuitemdao.modifyMenuItem(menuItem);
		System.out.println("Modify Menu Item : " + menuitemdao.getMenuItem(000002));
	}

}
