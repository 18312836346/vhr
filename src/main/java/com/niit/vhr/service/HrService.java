package com.niit.vhr.service;

import com.niit.vhr.mapper.HrMapper;
import com.niit.vhr.model.Hr;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HrService implements UserDetailsService {
    @Resource
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if(hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}