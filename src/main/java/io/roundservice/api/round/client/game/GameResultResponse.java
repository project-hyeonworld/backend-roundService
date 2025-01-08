package io.roundservice.api.round.client.game;

import io.roundservice.common.dto.NameDtos;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 8.
 */
public record GameResultResponse (
    String answer,
    NameDtos winners
){

}
