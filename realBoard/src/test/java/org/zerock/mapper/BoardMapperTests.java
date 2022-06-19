package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		log.info(".........................");
		boardMapper.getList();
	}
	
	@Test
	public void testInsert() {
		log.info(".......................");
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("Test");
		vo.setContent("contest test");
		vo.setWriter("writer test");
		
		boardMapper.insert(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		log.info(".......................");
		
		BoardVO board = new BoardVO();
		
		board.setTitle("select Test");
		board.setContent("select contest test");
		board.setWriter("select writer test");
		
		boardMapper.insertSelectKey(board);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(4L);
	}
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(2L);
		log.info("deleteCount : "+ count);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(1L);
		vo.setTitle("update test");
		vo.setContent("update test2");
		vo.setWriter("update test3");
		
		log.info("업데이트 테스트!!"+vo);
		log.info("count: " + boardMapper.update(vo));
	}
	
	
}
