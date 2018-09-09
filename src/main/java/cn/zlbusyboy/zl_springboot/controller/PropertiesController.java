package cn.zlbusyboy.zl_springboot.controller;

import cn.zlbusyboy.zl_springboot.properties.My1Properties;
import cn.zlbusyboy.zl_springboot.properties.My2Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by ling.zhang on 2018/9/9.
 */

@RequestMapping("/properties")
@RestController
public class PropertiesController {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    private final My2Properties my2Properties;


    @Autowired
    public PropertiesController(My2Properties my2Properties){
        this.my2Properties = my2Properties;
    }

    @GetMapping("/2")
    public My2Properties my2Properties(){
        logger.info("=================================================================================================");
        logger.info(my2Properties.toString());
        logger.info("=================================================================================================");
        return my2Properties;
    }
}
