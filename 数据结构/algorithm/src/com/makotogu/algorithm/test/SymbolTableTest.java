package com.makotogu.algorithm.test;

import com.makotogu.algorithm.symbol.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<Integer, String>();
        symbolTable.put(1,"小王");
        symbolTable.put(2,"老王");
        System.out.println(symbolTable.size());
        symbolTable.delete(2);
        symbolTable.put(1, "老王八");
        System.out.println(symbolTable.get(1));
    }
}
