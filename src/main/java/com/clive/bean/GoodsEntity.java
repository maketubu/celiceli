package com.clive.bean;

/**
 * 商品类
 */
public class GoodsEntity {

    private String goodsID;//商品ID
    private String goodsName;//商品名字
    private String goodsPrice;//商品价格
    private String goodsImgUrl;//商品图片地址
    private int goodsStock;//商品库存

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goodsID='" + goodsID + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsImgUrl='" + goodsImgUrl + '\'' +
                ", goodsStock=" + goodsStock +
                '}';
    }
}
