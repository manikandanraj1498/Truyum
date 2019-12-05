package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author ManiKandan V
 *
 */
public class CartDaoSqlImplTest {
	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub

		testAddCartItem();
		testRemoveCartItem();
		testGetAllCartItems();

	}

	private static void testAddCartItem() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(1, 1);
		System.out.println("MenuItem added to the cart successfully");
	}

	private static void testGetAllCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemList = cartDaoSqlImpl.getAllCartItem(2);
			System.out.println(menuItemList);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testRemoveCartItem() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(1, 5);
		System.out.println("MenuItem deleted");

	}

}
