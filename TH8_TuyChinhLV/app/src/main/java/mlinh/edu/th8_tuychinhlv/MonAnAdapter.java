package mlinh.edu.th8_tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter  extends BaseAdapter {
    //
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;
    private int i;
    //hàm tạo


    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.context = _context;
        this.dsMonAn = dsMonAn;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {

        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //View item hiện hành
        View viewHienHanh = convertView;
        //Kiểm tra
        if (viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan, null);
        //lấy dữ liệu
        MonAn monAnHienTai = dsMonAn.get(i);
        //Gán lên các điều khiển
        //Tìm điều khiển
        TextView textView_TenMon = (TextView) viewHienHanh.findViewById(R.id.tvMonAn);
        TextView textView_DonGia = (TextView) viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = (TextView) viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView_AVT = (ImageView) viewHienHanh.findViewById(R.id.imgAVT);
        //Set lên
        textView_TenMon.setText(monAnHienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView_AVT.setImageResource(monAnHienTai.getIdAnhMinhHoa());
        return viewHienHanh;

    }
}
