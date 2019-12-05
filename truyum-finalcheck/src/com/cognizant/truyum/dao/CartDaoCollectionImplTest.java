package com.cognizant.truyum.dao;

import java.util.List;
/**
 * 
 * @author Prakash_K
 *
 */

import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author ManiKandan V
 *
 */
public class CartDaoCollectionImplTest {
	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub

		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();

	}

	static void testAddCartItem() throws CartEmptyException {

		/*
		 * CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
		 * cartDao.addCartItem(1, 000004);
		 */
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.addCartItem(2, 4);
		cartDao.addCartItem(2, 3);
		List<MenuItem> menuItemList = cartDao.getAllCartItem(2);
		System.out.println("MenuItem list :" + menuItemList);

	}

	public static void testGetAllCartItems() throws CartEmptyException {
		/*
		 * CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		 * //CartDao cartDao = cartDaoCollectionImpl; List<MenuItem> menuItemList =
		 * cartDaoCollectionImpl.getAllCartItem(1); System.out.println("MenuItem list :"
		 * + menuItemList);
		 */
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;

		List<MenuItem> menuItemList = cartDao.getAllCartItem(2);
		System.out.println("MenuItem list :" + menuItemList);

	}

	public static void testRemoveCartItem() throws CartEmptyException {
		/*
		 * CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		 * CartDao cartDao = cartDaoCollectionImpl;
		 * cartDao.removeCartItem((long)1,(long)0000004); List<MenuItem> menuItemList =
		 * cartDao.getAllCartItem(1); System.out.println("MenuItem list after Removed:"
		 * + menuItemList);
		 */
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;

		try {
			cartDao.removeCartItem(2, 4);
			List<MenuItem> menuItemList = cartDao.getAllCartItem(2);
			System.out.println("MenuItem list after removed:" + menuItemList);
		} catch (Exception e) {
			throw new CartEmptyException("Cart is empty");
		}

	}

}
