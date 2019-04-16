package edu.uh.tech.cis3368.semesterproject;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.*;

@Controller
public class ProductController {

    public ListView<Product> productListView;

    public TextField productname;
    public TextField productquantity;

    public Button btnAddProduct;
    public Button btnDeleteProduct;
    public Button btnDone;

    @Autowired
    private ProductRepository productRepository;


    public void UpdateButton (){


}


}





