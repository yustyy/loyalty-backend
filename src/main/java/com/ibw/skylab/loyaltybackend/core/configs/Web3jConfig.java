package com.ibw.skylab.loyaltybackend.core.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.crypto.exception.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Configuration
public class Web3jConfig {

    @Value("${ethereum.network.url}")
    private String networkUrl;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(networkUrl));
    }

}
