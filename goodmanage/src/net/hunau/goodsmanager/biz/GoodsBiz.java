package net.hunau.goodsmanager.biz;

import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.dao.GoodsDAO;



public class GoodsBiz {
	
	private GoodsDAO gd;
	
	public GoodsBiz() {
		gd =new GoodsDAO();
		
	}
	
	public List<Goods> getGoods () {
		return gd.getGoods();
	}
	
	
	public void addGoods ( Goods goods) {
		gd.addGoods(goods);
	}
	
	public List<Goods> findGoods(Goods condition) {
		
		List<Goods> goods =new ArrayList<Goods>();
		if(condition.getId()!=0) {
			goods.add(gd.getGoods(condition.getId()));
			
		}else if (condition.getGoodname()!=null) {
			goods.addAll(gd.getGoods(condition.getGoodname()));
			
		}
		
		return goods;
		
	}
	
	
	
	
	public static void main(String[] args) {
	
	}

}
