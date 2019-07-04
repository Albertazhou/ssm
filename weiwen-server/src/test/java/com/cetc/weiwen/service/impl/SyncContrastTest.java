package com.cetc.weiwen.service.impl;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cetc.weiwen.service.SyncService;
import com.cetc.weiwen.vo.SynDictionaryVo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SyncContrastTest {
	
	@Autowired
	private SyncService syncService;
   
    
    @Test
    public void testSync() {
    	
    	SynDictionaryVo sVo=syncService.sync(1, 1, 1, 1,1,1,1,1,1);
    	
    	if(sVo.getDicDels().size()>0&&sVo.getDicEvents().size()>0&&sVo.getDicEventTypes().size()>0&&sVo.getOrgs().size()>0) {
    		
    		//System.out.println("测试通过");
    		
    	}
    	assertTrue(sVo.getDicDels().size()>0
    			&&sVo.getDicEvents().size()>0
    			&&sVo.getDicEventTypes().size()>0
    			&&sVo.getOrgs().size()>0
    			&&sVo.getDivisions().size()>0
    			&&sVo.getEventLevelContacts().size()>0
    			&&sVo.getEventTypeFunctionTypes().size()>0
    			&&sVo.getFunctionTypes().size()>0
    			&&sVo.getPositions().size()>0);
    	
    }
  
}
