package com.example.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class CorpCards extends Corporate {

    private List<CardHolder> cardHolderList = new ArrayList<>();
}
