package us.abstracta.opencart.vos;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import framework.utils.ExcelsUtils;

public class ProductsVO {
	private String product1;
	private String cost1;
	private String product2;
	private String cost2;
	private String product3;
	private String cost3;

	public ProductsVO(String ruta, String hoja) {
		XSSFSheet pagina = ExcelsUtils.obtenerPaginaExcel(ruta, hoja);
		this.product1 = ExcelsUtils.obtenerCelda(pagina, 2, "B").getStringCellValue();
		this.cost1 = ExcelsUtils.obtenerCelda(pagina, 2, "C").getStringCellValue();
		this.product2 = ExcelsUtils.obtenerCelda(pagina, 3, "B").getStringCellValue();
		this.cost2 = ExcelsUtils.obtenerCelda(pagina, 3, "c").getStringCellValue();
		this.product3 = ExcelsUtils.obtenerCelda(pagina, 4, "B").getStringCellValue();
		this.cost3 = ExcelsUtils.obtenerCelda(pagina, 4, "C").getStringCellValue();
	}

	public String getProduct1() {
		return product1;
	}

	public String getCost1() {
		return cost1;
	}

	public String getProduct2() {
		return product2;
	}

	public String getCost2() {
		return cost2;
	}

	public String getProduct3() {
		return product3;
	}

	public String getCost3() {
		return cost3;
	}

	@Override
	public String toString() {
		return "ProductsVO [product1=" + product1 + ", cost1=" + cost1 + ", product2=" + product2 + ", cost2=" + cost2
				+ ", product3=" + product3 + ", cost3=" + cost3 + "]";
	}

}
