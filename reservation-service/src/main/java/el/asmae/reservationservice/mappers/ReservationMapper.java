package el.asmae.reservationservice.mappers;

import el.asmae.reservationservice.DTO.ReservationRequestDto;
import el.asmae.reservationservice.DTO.ReservationResponseDto;
import el.asmae.reservationservice.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class ReservationMapper {
   /* private ModelMapper modelMapper = new ModelMapper();

    public ReservationResponseDto from(Reservation reservation){
        return modelMapper.map(reservation, ReservationResponseDto.class);
    }

    public Reservation to(ReservationRequestDto reservationRequestDto){
        return modelMapper.map(reservationRequestDto, Reservation.class);
    }*/

    //Another method without mapper model dependency
    public Reservation to(ReservationRequestDto reservationRequestDto ){
        Reservation reservation=new Reservation();
        BeanUtils.copyProperties(reservationRequestDto,reservation);
        return reservation;
    }
    public ReservationResponseDto from(Reservation reservation){
        ReservationResponseDto reservationResponseDto=new ReservationResponseDto();
        BeanUtils.copyProperties(reservation,reservationResponseDto);
        return reservationResponseDto;
    }
}
