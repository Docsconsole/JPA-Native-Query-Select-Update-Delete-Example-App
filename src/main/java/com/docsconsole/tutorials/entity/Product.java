package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
@NamedNativeQueries({

		@NamedNativeQuery(
				name = "selectProduct",
				query = "SELECT * FROM PRODUCT WHERE PROD_ID = ?",
				resultClass = Product.class
		),
		@NamedNativeQuery(
				name = "updateProduct",
				query = "UPDATE PRODUCT SET PROD_NAME = ? WHERE PROD_ID = ?",
				resultClass = Product.class
		),
		@NamedNativeQuery(
				name = "deleteProduct",
				query = "DELETE FROM PRODUCT WHERE PROD_NAME = ? AND PROD_ID = ?",
				resultClass = Product.class
		)
})

public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private long prodId;
	@Column(name = "PROD_NAME")
	private String prodName;
	@Column(name = "PROD_VENDOR")
	private String prodVendor;

	public Product() {
	}

}