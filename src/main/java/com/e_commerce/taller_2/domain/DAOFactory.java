package com.e_commerce.taller_2.domain;

import com.e_commerce.taller_2.domain.factory_method.IProductDAO;
import com.e_commerce.taller_2.domain.factory_method.Implementatios.ProductDAOMySQLImpl;
import com.e_commerce.taller_2.domain.factory_method.Implementatios.ProductDAOOracleImpl;

public class DAOFactory {
    public static IProductDAO getProductDAO() {
        String dbType = Configuracion.configureAdapterDB();
        
        switch (dbType) {
            case "MySQL":
                return new ProductDAOMySQLImpl();
            case "Oracle":
                return new ProductDAOOracleImpl();
            default:
                throw new UnsupportedOperationException("Database type not supported: " + dbType);
        }
    }
}
