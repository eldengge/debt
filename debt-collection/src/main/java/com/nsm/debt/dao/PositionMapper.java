package com.nsm.debt.dao;

import com.nsm.debt.entities.Position;
import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    Position selectByPrimaryKey(Integer id);

    List<Position> selectAll();

    int updateByPrimaryKey(Position record);
    
}