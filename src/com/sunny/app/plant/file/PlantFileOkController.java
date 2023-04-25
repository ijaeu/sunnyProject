package com.sunny.app.plant.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.plant.file.dao.PlantFileDAO;

public class PlantFileOkController implements Execute {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlantFileDAO plantFileDAO = new PlantFileDAO();
        int plantNumber = Integer.parseInt(req.getParameter("plantNumber"));
        int plantFiles = plantFileDAO.selectPlantFile(plantNumber);
        req.setAttribute("plantFiles", plantFiles);
        
        System.out.println(plantFiles);
    }
}
