package com.twjitm.core.common.service;

import com.twjitm.core.common.netstack.session.ISession;
import com.twjitm.core.common.netstack.session.tcp.NettyTcpSession;

/**
 * @author EGLS0807 - [Created on 2018-07-26 20:37]
 * @company http://www.g2us.com/
 * @jdk java version "1.8.0_77"
 */
public interface INettyChannleOperationService {

    public ISession findNettySession(long sessionId);

    public boolean addNettySession(NettyTcpSession session);

    public void removeNettySession(long session);


}
