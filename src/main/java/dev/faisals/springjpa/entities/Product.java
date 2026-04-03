package dev.faisals.springjpa.model;

import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class Product {

    private int prodId;
    private String prodName;
    private int price;

    // 1. بديل @NoArgsConstructor (المنشئ الفارغ)
    // ضروري لـ Spring و Jackson لإنشاء نسخة فارغة من الكائن قبل تعبئة البيانات
    public Product() {
    }

    // 2. بديل @AllArgsConstructor (المنشئ الكامل)
    // يسهل إنشاء المنتج وتمرير جميع بياناته مباشرة في سطر واحد
    public Product(int prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    // 3. بديل @Data (Getters and Setters)
    // تسمح للـ Frameworks بالوصول للحقول الخاصة وتعديلها
    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 4. بديل @Data (toString)
    // مفيد جداً لطباعة بيانات المنتج في الـ Console أثناء عمل Debugging
    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }

    // 5. بديل @Data (equals & hashCode)
    // مهم جداً لمقارنة المنتجات ببعضها أو استخدامها داخل HashSet أو HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodId == product.prodId &&
                price == product.price &&
                Objects.equals(prodName, product.prodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, prodName, price);
    }
}