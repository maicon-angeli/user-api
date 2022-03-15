package com.zallpy.userapi.dto.response;

import com.zallpy.userapi.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamsGetCSV {
    private String id;

    private String examCost;

    private String examName;

    private String fullName;

    private String rg;

    private String cpf;

    private String email;

    private String susNumber;

    private String age;

    private String active;

    public void format() {
        this.examCost = correctSizeTo(examCost, 12);
        this.examName = correctSizeTo(examName, 65);
        this.fullName = correctSizeTo(fullName, 80);
        this.rg = correctSizeTo(rg, 25);
        this.cpf = correctSizeTo(cpf, 25);
        this.email = correctSizeTo(email, 70);
        this.susNumber = correctSizeTo(susNumber, 25);
        this.age = correctSizeTo(age, 3);
        this.active = correctSizeTo(active, 5);


    }
    private String correctSizeTo(String variable, int num) {
        if (variable.length() < num) {
            variable = variable.trim();
            StringBuilder sb = new StringBuilder();
            int size = num - variable.length();

            for (int i = 0; i < size; i++) {
                sb.append("0");
            }
            sb.append(variable);
            return StringUtils.leftPad(sb.toString(), num - variable.length());
        } else {
            throw sizeNotAcceptableException(variable, num);
        }
    }

    private ApiException sizeNotAcceptableException(String variable, int num) {
        return new ApiException(HttpStatus.NOT_ACCEPTABLE,
                "O valor " + variable + " do usuário " + this.fullName + " Não é " + "aceitável, pois supera o valor de " + num);
    }

    public static String insereZerosEsquerda(String pValue, int pLength) {

        if (pValue == null) {
            pValue = "";
        }
        pValue = pValue.trim();

        StringBuilder sb = new StringBuilder();
        int size = pLength - pValue.length();

        for (int i = 0; i < size; i++) {
            sb.append("0");
        }
        sb.append(pValue);

        return sb.toString();
    }

}
